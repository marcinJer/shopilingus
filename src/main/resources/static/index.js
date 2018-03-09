const date = new Date().getFullYear();
document.querySelector('.date').innerHTML = date;

const HOST = 'http://localhost:8080';

function initShopFilters(shops) {
    const shopFilterSelect = document.querySelector('.shop-select');
    shops.forEach(shop => {
        const shopElement = document.createElement('option');
        shopElement.setAttribute('value', shop.id);
        shopElement.innerHTML = shop.name;
        shopFilterSelect.appendChild(shopElement);
    });
}

function initFilters(filters) {
    const { shops, shopTypes } = filters;
    initShopFilters(shops);
    initShopTypesFilters(shopTypes);
}

const filtersPromise = fetch(HOST + '/filters')
    .then(response => response.json())
    .then(filters => initFilters(filters))
    .catch(error => console.log(error))


function initShopTypesFilters(shopTypes) {
    const shopTypeSelect = document.querySelector('.shop-types');

    shopTypes.forEach(shopType => {
        const shopTypeInput = document.createElement('input');
        shopTypeInput.setAttribute('value', shopType);
        shopTypeInput.setAttribute('type', 'checkbox');

        const shopTypeLabel = document.createElement("label");
        const shopTypeDiv = document.createElement("div");
        shopTypeLabel.appendChild(shopTypeInput);
        shopTypeLabel.innerHTML += shopType;
        shopTypeSelect.appendChild(shopTypeLabel);
        shopTypeSelect.appendChild(shopTypeDiv);
    })
}

function getFilterParams() {
    const productNamePhrase = document.querySelector('.product-name-phrase').value;
    const minProductPrice = document.querySelector('.min-product-price').value;
    const maxProductPrice = document.querySelector('.max-product-price').value;
    const shopNamePhrase = document.querySelector('.shop-name-phrase').value;
    const shopTypesCheckboxes = document.querySelector('.shop-types label input');
    const shopIds = document.querySelector('.shop-select').value;

    const shopTypes = Array.from(shopTypesCheckboxes)
        .filter(shopTypes => shopTypes.checked)
        .map(shopType => shopTypes.value);

    return {
        productNamePhrase,
        shopNamePhrase,
        shopIds,
        shopTypes,
        minProductPrice,
        maxProductPrice
    }
}

function onLoadShops() {
    const filteringParams = getFilterParams();
    // console.log(filteringParams);
    // const queryString = createQueryParamsString(filteringParams);
    // console.log(queryString);
    fetchFilteredShops(filteringParams).then(showShops);
}

const button = document.querySelector('.filter-button').addEventListener('click', onLoadShops);

let createQueryParamsString = object => Object.keys(object)
    .filter(key => object[key] !== undefined)
    .filter(key => String(object[key]) !== '')
    .map(key => `${key}=${object[key]}`)
    .join('&');

function fetchFilteredShops(filteringParams) {
    return fetch(HOST + '/shops' + '?' + createQueryParamsString(filteringParams))
        .then(response => response.json())
        .catch(error => console.log(error))
}

function createShopElement(shop) {
    const shopProductsContainer = document.createElement('ul');
    const shopElement = document.createElement('div');
    const shopName = document.createElement('span');
    const shopFloor = document.createElement('span');
    const shopBox = document.createElement('span');

    shopName.innerHTML = "Name: " + shop.name;
    shopFloor.innerHTML = " Floor:" + shop.location.floor;
    shopBox.innerHTML = " Box: " + shop.location.box;

    shopName.addEventListener('click', () => onShowShopDetails(shop, shopProductsContainer));

    shopElement.appendChild(shopName);
    shopElement.appendChild(shopFloor);
    shopElement.appendChild(shopBox);
    shopElement.appendChild(shopProductsContainer);
    return shopElement;
}

function showShops(shops) {
    const shopDivContainer = document.querySelector('.shop-elements');
    // const shopDivs = shops.map(shop => createShopElement(shop));
    // shopDivs.forEach(shopDiv => shopDivContainer.appendChild(shopDiv));
    shops
        .map(shop => createShopElement(shop))
        .forEach(shopDiv => shopDivContainer.appendChild(shopDiv))
}

function fetchShopDetails(shop) {
    return fetch(HOST + `/shops/${shop.id}/products`)
        .then(response => response.json())
        .catch(error => console.log(error))
}

function createProductElement(product) {
    const productElement = document.createElement('li');
    const productName = document.createElement('span');
    const productQuantity = document.createElement('span');

    productName.innerHTML = product.name;
    productQuantity.innerHTML = product.quantity;

    productElement.appendChild(productName);
    productElement.appendChild(productQuantity);
    return productElement;
}

function onShowShopDetails(shop, shopProductsContainer) {
    fetchShopDetails(shop).then(products => {
        products
        .map(product => createProductElement(product))
        .forEach(productElement => shopProductsContainer.appendChild(productElement))
    });
}