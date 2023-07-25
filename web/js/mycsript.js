var storedValue = localStorage.getItem('selectedOption') || '';

// store current value when select option changes
document.querySelector('.danhmuc').addEventListener('change', function() {
    var currValue = this.value;
    localStorage.setItem('selectedOption', currValue);
    document.querySelector('#selectedOption').textContent = currValue;
});

// set stored value when page loads
document.querySelector('.danhmuc').value = storedValue;
document.querySelector('#selectedOption').textContent = storedValue;