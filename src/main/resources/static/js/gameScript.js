function generateNum() {
    let number = [];
    while (number.length < 4){
        let newNum = Math.floor(Math.random()*10);
        if(number.indexOf(newNum) < 0){
            number.push(newNum);
        }
    }
    console.log(number);
    return number;
}
let goal = generateNum();
let move=0;


function game() {
    let playersNumber1 = document.querySelector('#player1').value;
    let playersNumber2 = document.querySelector('#player2').value;
    let playersNumber3 = document.querySelector('#player3').value;
    let playersNumber4 = document.querySelector('#player4').value;

    let number=[];
    number.push(playersNumber1);
    number.push(playersNumber2);
    number.push(playersNumber3);
    number.push(playersNumber4);

    //Ввод с клавиатуры
    // let playersNumber = document.querySelector('#player').value;
    // for(let i = 0; i<4; i++){
    //     let newUserArrElement = parseInt(playersNumber.substr(i,1));
    //     number.push(newUserArrElement)
    // }
    check(number);
}

//Проверка коров и быков
function check(number) {
    let bulls = 0;
    let cows = 0;
    for(let i = 0; i< 4; i++){
        if(number[i]==goal[i])
            bulls++;
        else if(goal.indexOf(number[i]) >= 0)cows++;
    }
    writeTurn(number, bulls, cows);
    console.log(goal);
    console.log('b '+bulls);
    console.log('c '+cows);
}

function saveGame(move, number) {
    // let score=1000-move*100;
    // score=(score<0)?0:score;
    let j={
        score: `${move}`,
        hidden_number: `${+number.join("")}`
    };

    //отправка json
    let xhr = new XMLHttpRequest();
    let json = JSON.stringify(j);
    xhr.open("POST", '/saveGame')
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);
}

function writeTurn(number, bulls, cows) {
    let table = document.querySelector('.turnsList');
    let newLine = document.createElement('p');
    move++;
    newLine.innerHTML = '<span class="guessed">' +move+'. '+number + ' быки: ' + bulls + '; коровы: ' + cows;
    if(bulls==4) {
        saveGame(move,number);
        newLine.innerHTML = 'Вы выиграли!!! Загаданное число: ' + number.toString().split(',').join('');
    }
    table.appendChild(newLine);
}
