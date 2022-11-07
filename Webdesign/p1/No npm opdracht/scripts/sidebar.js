fetch('../pages/templates/sidebar.html')
    .then(res => res.text())
    .then(text => {
        let oldelem = document.querySelector("script#sidebar");
        let newelem = document.createElement("div");
        newelem.innerHTML = text;
        oldelem.parentNode.replaceChild(newelem,oldelem);
    })