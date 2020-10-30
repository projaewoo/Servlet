window.onload = function() {
    //여러 개의 버튼들을 buttons에 저장.
    var buttons = document.getElementsByTagName('button');
    //0번째 버튼 눌렀을 때, 이벤트 부여.
    //0번째 버튼 클릭하면 myclikc 함수 호출.
    buttons[0].addEventListener('click', myclick, false);
}

function myclick() {
    history.go(-1);     //뒤로가기  =  history.back();
}