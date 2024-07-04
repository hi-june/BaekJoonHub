function solution(k, ranges) {
    let colatz = [];
    colatz.push(k);
    
    while (k != 1) {
        if (k % 2 == 0) {
            k = k / 2;
        } else {
            k = (3 * k) + 1;
        }
        
        colatz.push(k);
    }
    
    let answer = [];
    let n = colatz.length - 1;
    
    for (let r of ranges) {
        let s = r[0];
        let e = r[1];
        
        if (n + e < s) {
            answer.push(-1.0);
        } else {
            let total = 0;
            for (let i = s; i < n + e; i++) {
                total += (colatz[i] + colatz[i + 1]) / 2;
            }
                
            answer.push(total);
        }
    }
    
    return answer;
}