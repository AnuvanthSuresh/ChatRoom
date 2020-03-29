var messages = document.getElementById("messages");
var textbox = document.getElementById("textbox");
var button = document.getElementById("send");
var usr = document.getElementById("user");
button.addEventListener("click",function(){
	
	var newMessage=document.createElement("li");
	newMessage.innerHTML = textbox.value;
	messages.appendChild(newMessage);
	
})

