

document.addEventListener('DOMContentLoaded', function () {

    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

    var sidebarItems = document.querySelectorAll('.list-group-item-action');
    sidebarItems.forEach(function (item) {
        item.addEventListener('click', function (event) {
            event.preventDefault();
            var pageUrl = event.target.getAttribute('href');

            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        console.log(pageUrl);
                        document.getElementById('page-content').innerHTML = xhr.responseText;
                        new JSTable("#viewTable");
                    } else {
                        console.error('Error loading page: ' + xhr.status);
                    }
                }
            };
            xhr.open('GET', pageUrl, true);
            xhr.send();
        });
    });


    document.addEventListener("click", function(event) {
        if (event.target && event.target.id === "addBtn") {
            event.preventDefault();

            var href = event.target.getAttribute('href');

            fetch(href)
                .then(response => response.text())
                .then(html => {
                    var dashboardContent = document.getElementById('page-content');
                    dashboardContent.innerHTML = html;
                })
                .catch(error => {
                    console.error('Error loading content:', error);
                });
        }
    });

     document.addEventListener("click", function(event) {
            if (event.target && event.target.matches("#viewTable #editBtn")) {
                event.preventDefault();
                var href = event.target.getAttribute('href');

                fetch(href)
                    .then(response => response.text())
                    .then(html => {
                        var dashboardContent = document.getElementById('page-content');
                        dashboardContent.innerHTML = html;
                    })
                    .catch(error => {
                        console.error('Error loading content:', error);
                    });
            }
    });



//    document.addEventListener("click", function(event) {
//            if (event.target && event.target.id === "editBtn") {
//                event.preventDefault();
//
//                var href = event.target.getAttribute('href');
//
//                fetch(href)
//                    .then(response => response.text())
//                    .then(html => {
//                        var dashboardContent = document.getElementById('page-content');
//                        dashboardContent.innerHTML = html;
//                    })
//                    .catch(error => {
//                        console.error('Error loading content:', error);
//                    });
//            }
//        });



//Selecting sidebar items based on the url
// Parse URL parameters
//    const urlParams = new URLSearchParams(window.location.search);
//    const selectedSection = urlParams.get('selected');
//
//    // Select the appropriate sidebar item based on the parameter value
//    const sidebarItems = document.querySelectorAll('.list-group-item-action');
//    sidebarItems.forEach(function (item) {
//        const href = item.getAttribute('href');
//        console.log("href = " + href);
//        console.log("passed reference" + ${selectedSection})
//
//        if (href === `/admin/${selectedSection}`) {
//            item.classList.add('active'); // Apply styling to highlight the selected item
//        }
//    });

});


document.addEventListener("change", function(event) {
    if (event.target && event.target.matches("#categorySelect")) {
        fetchSubCategories();
    }
});

function fetchSubCategories() {
    console.log("fetchSubCategories() called");
    var selectedCategory = document.getElementById("categorySelect").value;
    console.log("Selected Category: " + selectedCategory);

    fetch('/subCategory/' + selectedCategory)
        .then(response => response.json())
        .then(data => {
            console.log("Data received:", data);
            populateSubCategories(data);
        })
        .catch(error => {
            console.error("Error fetching subcategories:", error);
        });
}

function populateSubCategories(subCategories) {
    console.log("populateSubCategories() called");
    var subCategoryDropdown = document.getElementById("subcategorySelect");
    subCategoryDropdown.innerHTML = ""; // Clear existing options

    if (subCategories == null) {
        console.log("Subcategories is null");
    } else {
        subCategories.forEach(subCategory => {
            console.log("Adding subcategory:", subCategory.subCategoryName);
            var option = document.createElement("option");
            option.text = subCategory.subCategoryName;
            option.value = subCategory.subCategoryName;
            subCategoryDropdown.appendChild(option);
        });
    }
}

document.addEventListener("click", function(event) {
    if (event.target && event.target.matches("#excelBtn")) {
        event.preventDefault();
        console.log("Excel button clicked")
        generateExcel();
    }
});

function generateExcel() {
    let data = document.getElementById('viewTable');
    let fp = XLSX.utils.table_to_book(data, { sheet: 'sarvesg' });
    let wbout = XLSX.write(fp, { bookType: 'xlsx', type: 'binary' });

    function s2ab(s) {
        var buf = new ArrayBuffer(s.length);
        var view = new Uint8Array(buf);
        for (var i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
        return buf;
    }

    var blob = new Blob([s2ab(wbout)], { type: "application/octet-stream" });
    saveAs(blob, 'Export.xlsx');
}


document.addEventListener("click", function(event) {
    if (event.target && event.target.matches("#pdfBtn")) {
        event.preventDefault();
        console.log("PDF button clicked")
        generatePdf();
    }
});


function generatePdf(){
  const table = document.getElementById("viewTable");

//  // Create a new PDF document
//  const doc = new jsPDF();
//
//  // Add the table to the PDF
//  doc.autoTable({
//    html: table,
//    startY: 20, // Adjust starting position as needed
//  });
//
//  // Save the PDF
//  doc.save("table.pdf");

//    const pdf = new jsPDF();
//     const element = document.body;
//
//     pdf.html(element, {
//      callback: function (pdf) {
//
//    // Save the PDF to a file or display it
//       pdf.save("output.pdf");
//      },
//     });

                html2canvas($('#viewTable')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("pdfDoc.pdf");
                }
            });
}


//
//window.addEventListener('DOMContentLoaded', event => {
//
//    // Toggle the side navigation
//    const sidebarToggle = document.body.querySelector('#sidebarToggle');
//    if (sidebarToggle) {
//        // Uncomment Below to persist sidebar toggle between refreshes
//        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
//        //     document.body.classList.toggle('sb-sidenav-toggled');
//        // }
//        sidebarToggle.addEventListener('click', event => {
//            event.preventDefault();
//            document.body.classList.toggle('sb-sidenav-toggled');
//            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
//        });
//    }
//
//
//
//
//});
//
//// JavaScript for handling AJAX calls and updating page content
//
//// Add click event listeners to sidebar items
//document.addEventListener('DOMContentLoaded', function () {
//    var sidebarItems = document.querySelectorAll('.list-group-item-action');
//
//    console.log("Content loaded")
//    sidebarItems.forEach(function (item) {
//        item.addEventListener('click', function (event) {
//            event.preventDefault(); // Prevent the default action
//            var pageUrl = event.target.getAttribute('href'); // Get the URL from the clicked sidebar item
//
//            var xhr = new XMLHttpRequest();
//            xhr.onreadystatechange = function () {
//                if (xhr.readyState === XMLHttpRequest.DONE) {
//                    if (xhr.status === 200) {
//                        console.log(pageUrl)
//                        document.getElementById('page-content').innerHTML = xhr.responseText;
//                        new JSTable("#viewTable")
//                    } else {
//                        console.error('Error loading page: ' + xhr.status);
//                    }
//                }
//            };
//            xhr.open('GET', pageUrl, true);
//            xhr.send();
//        });
//    });
//});
//
//document.addEventListener("DOMContentLoaded", function() {
//    // Add click event listener to the document and use event delegation
//    document.addEventListener("click", function(event) {
//        // Check if the clicked element is the "Add City" button
//        if (event.target && event.target.id === "addBtn") {
//            event.preventDefault(); // Prevent the default action of following the link
//
//            // Get the href attribute value of the clicked link
//            var href = event.target.getAttribute('href');
//
//            // Fetch the content of the href URL
//            fetch(href)
//                .then(response => response.text())
//                .then(html => {
//                    // Replace the content of the dashboard with the fetched HTML
//                    var dashboardContent = document.getElementById('page-content');
//                    dashboardContent.innerHTML = html;
//                })
//                .catch(error => {
//                    console.error('Error loading content:', error);
//                });
//        }
//    });
//});
//
//
//
//
//
////
////document.addEventListener("DOMContentLoaded", function() {
////    // Get the "Add" link element
////    var addLink = document.querySelector('#addBtn');
////
////    // Add click event listener to the "Add" link
////    addLink.addEventListener("click", function(event) {
////        event.preventDefault(); // Prevent the default action of following the link
////
////        // Get the href attribute value of the clicked link
////        var href = addLink.getAttribute('href');
////
////        // Fetch the content of the href URL
////        fetch(href)
////            .then(response => response.text())
////            .then(html => {
////                // Replace the content of the dashboard with the fetched HTML
////                var dashboardContent = document.getElementById('page-content');
////                dashboardContent.innerHTML = html;
////            })
////            .catch(error => {
////                console.error('Error loading content:', error);
////            });
////    });
////});
//
////
////new JSTable("#citiesTable");
////new JSTable("#restaurantTable");
////new JSTable("#areaTable");
////new JSTable("#citiesTable");
////new JSTable("#citiesTable");
////new JSTable("#citiesTable");
////new JSTable("#viewRestaurantTable");