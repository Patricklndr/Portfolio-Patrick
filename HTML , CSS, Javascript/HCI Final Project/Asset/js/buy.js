$(document).ready(function(){
    // var txt = "Open";
    $("#seat").click(function(){
        if( $("#seat").text() == "Hide Seat"){
            $("#seat").text("Show Seat");
            $(".image").slideUp("slow");
        }else{
            $("#seat").text("Hide Seat");
            $(".image").slideDown("slow");
        }
    });
});

function buy(){
    var ticket = document.getElementById("tickettype").value;
    var qty = document.getElementById("quantity").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var address = document.getElementById("address").value;
    var useraggree = document.getElementById("terms");

    if(qty <= 0 || qty >= 10){
        $("#error").text("Quantiy must be 1-10");
    }else if(name.length == 0){
        $("#error").text("Name must be filled");
    }else if(name.length <= 4 || name.length > 20){
        $("#error").text("Name length must be 5-20");
    }else if(email.length == 0){
        $("#error").text("Email must be filled");
    }else if(phone.length == 0){
        $("#error").text("Phone Number must be filled");
    }else if(address.length == 0){
        $("#error").text("Address must be filled");
    }else if(address.length < 10 || address.length >= 50){
        $("#error").text("Address length must be 10-50");
    }else if(!useraggree.checked){
        $("#error").text("Must aggree with Terms & Conditions");
    }else{
        var random = getrandom();
        var spoil = "Order ID : "+random+"\nYour Ticket : "+ticket+"\nQuantity : "+qty+"\nName : "+name+"\nEmail : "+email+"\nPhone : "+phone+"\nAddress : "+address+"\n";
        
        if(confirm(spoil)){
            $(".thanks").css('display', "block");
            $(".content").css('display', "none");
            $("#orderid").text(random);

        }else{
            $("#error").text("");
            random = "";
            useraggree.checked = false;
        }

    }

}

function getrandom(){
    var random = "";
    var abjad = "ABCDEFGHIJKLMNOPQRSTU";
    var length = abjad.length;
    for ( var i = 0; i < 2; i++ ) {
        random += abjad.charAt(Math.floor(Math.random() * length));
    }
    for (var i= 0;i<3;i++){
        random += Math.floor(Math.random() * 10);
    }
    return random;
}