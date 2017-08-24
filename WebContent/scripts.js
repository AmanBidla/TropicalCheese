/**
 * 
 */

function validate(){
	var user = document.forms["loginForm"]["username"].value;
	var pass = document.forms["loginForm"]["password"].value;
	
	if(user=="" || pass==""){
		alert("Username/Password cannot be blank!");
		return false;
	}
}


function inLineEdit(id){
    var listt = document.getElementsByName(id);
    
    var sizee = listt.length;

    for (var index = 0; index < sizee; index++) {
        var element = listt[index];
        element.removeAttribute("disabled");
    }
}

function toServlet(nom){
    var listt = document.getElementsByName(nom);
    
    var sizee = listt.length;

    var items = [];
    for (var index = 0; index < sizee; index++) {
        var element = listt[index];
        items.push(element.value); //.removeAttribute("disabled");
    }

    var request = new XMLHttpRequest();
    var stringParameter = "Something String";
    //request.open("GET", "http://localhost:8080/TropicalCheese/Bridge?stringParameter="+stringParameter , true);
    window.location = "http://localhost:8080/TropicalCheese/Bridge?id=" + encodeURIComponent(nom) 
                    + "&date=" + encodeURIComponent(items[1])
                    + "&cusid=" + encodeURIComponent(items[2])
                    + "&cusname=" + encodeURIComponent(items[3])
                    + "&address=" + encodeURIComponent(items[4])
                    + "&routenum=" + encodeURIComponent(items[5]);
    //request.send(null);
    //document.writeln(items[1]);
}

function viewDetails(id){

    var listt = document.getElementsByName(id);
    
    var sizee = listt.length;

    var message = "";
    var items = [];
    for (var index = 0; index < sizee; index++) {
        var element = listt[index];
        items.push(element.value);
         //.removeAttribute("disabled");
    }
    message = message.concat("Tracking Number: ").concat(items[0]).concat("\n"); 
    message = message.concat("Date: ").concat(items[1]).concat("\n");
    message = message.concat("Customer ID: ").concat(items[2]).concat("\n");
    message = message.concat("Customer Name: ").concat(items[3]).concat("\n");
    message = message.concat("Address: ").concat(items[4]).concat("\n");
    message = message.concat("Route Number: ").concat(items[5]);   
    alert(message);
}

function deleteItem(nom){
    var listt = document.getElementsByName(nom);
    
    var sizee = listt.length;

    var items = [];
    for (var index = 0; index < sizee; index++) {
        var element = listt[index];
        items.push(element.value); //.removeAttribute("disabled");
    }

    var request = new XMLHttpRequest();
    var stringParameter = "Something String";
    //request.open("GET", "http://localhost:8080/TropicalCheese/Bridge?stringParameter="+stringParameter , true);
    window.location = "http://localhost:8080/TropicalCheese/Bridge2?id=" + encodeURIComponent(nom) 
                    + "&date=" + encodeURIComponent(items[1])
                    + "&cusid=" + encodeURIComponent(items[2])
                    + "&cusname=" + encodeURIComponent(items[3])
                    + "&address=" + encodeURIComponent(items[4])
                    + "&routenum=" + encodeURIComponent(items[5]);
    //request.send(null);
    //document.writeln(items[1]);
}

function filterItems(){
    //var orderDate = document.getElementById("orderDate").value;
    var customerID = document.getElementById("customerID").value;
    var customerName = document.getElementById("customerName").value;
    var salesManager = document.getElementById("salesManager").value;

    window.location = "http://localhost:8080/TropicalCheese/Filters?" 
                    + "&customerID=" + encodeURIComponent(customerID)
                    + "&customerName=" + encodeURIComponent(customerName)
                    + "&salesManager=" + encodeURIComponent(salesManager);
}