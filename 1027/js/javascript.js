window.onload = function() {
    document.getElementById('btn')
        .addEventListener('click', myclick, false);
}

function myclick() {
    var name = document.getElementsById('irum').value;
    var today = new Date().toLocaleString;
    var jumsu = 0;
     //답 저장하는 배열.
    var array = [(5 + 6), (8 - 3), (7 * 6), (15 / 3), (8 + 6 - 3 * 2 / 2)];
    for(var i = 1; i < 6; i++) {
        var munje = document.getElementById('question' + i);        //question1, question2, ... question5
        if(munje.value == array[i-1]) {     //배열은 0부터 시작.
            jumsu++;
        }else{
            wrongStyleChange(munje);        //틀린 텍스트 박스를 보냄.
        }
    }
    var str = ' ';
    str += '<div>' + name + '님이 방문한 날짜는 ' +
                today + '이며 </div>';
    str += '<div>' + array.length + '문제 중 ' + 
                jumsu + '개를 맞추셔서 </div>';
    str += '<div>' + jumsu * 20 + 
            '점 이며 틀린 문제는 빨간 색으로 표시했습니다.</div>';
    document.getElementById('resultarea').innerHTML = str;      //id가 resultarea인 div 태그 사이에 str 넣기.
    document.getElementById('resultarea').style.visibility = 'visible';
}

function wrongStyleChange(elem) {       //파라미터로 넘어온 것 : 텍스트 박스.
    elem.style.backgroundColor = 'red';
    elem.style.color = 'white';             //글씨 화이트
    elem.style.fontWeight = '900';      //진하게.
}