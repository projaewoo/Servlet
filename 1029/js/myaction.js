window.onload = function(){
    var buttons = document.getElementsByTagName('button');
    buttons[0].addEventListener('click', myclick, false);
}

function myclick(){
    history.go(-1);
}