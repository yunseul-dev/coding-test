function solution(name, yearning, photo) {
    var answer = [];
    
    for(let i = 0; i < photo.length; i++){
        let tmp = 0;
        for(let k = 0; k < name.length; k++){
            if(photo[i].includes(name[k])){
                tmp += yearning[k]
            }
        }
        
        answer.push(tmp)
    }
    
    return answer;
}