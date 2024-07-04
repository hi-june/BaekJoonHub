function solution(topping) {
    let chulsu = new Map();
    let bro = new Map();
    
    for (let t of topping) {
        chulsu.set(t, chulsu.has(t) ? chulsu.get(t) + 1 : 1);
    }
    
    let answer = 0;
    for (let i = 0; i < topping.length - 1; i++) {
        let target = topping[i];
        
        if (chulsu.get(target) == 1) {
            chulsu.delete(target);
        } else {
            chulsu.set(target, chulsu.get(target) - 1);
        }
        
        bro.set(target, bro.has(target) ? bro.get(target) + 1 : 1);
        
        if (chulsu.size == bro.size) answer++;
    }
    
    return answer;
}