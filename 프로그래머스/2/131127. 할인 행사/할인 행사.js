function solution(want, number, discount) {
    let wMap = new Map();
    for (let i = 0; i < want.length; i++) {
        wMap.set(want[i], number[i]);
    }
    
    let dMap = new Map();
    for (let i = 0; i < 10; i++) {
        dMap.set(discount[i], dMap.has(discount[i]) ? dMap.get(discount[i]) + 1 : 1);
    }
    
    let idx = 0;
    let count = 0;
    while(idx < discount.length - 9) {
        // check
        if (check(wMap, dMap)) count++;
        
        // move
        let removeP = discount[idx];
        if (dMap.get(removeP) - 1 === 0) {
            dMap.delete(removeP);
        } else {
            dMap.set(removeP, dMap.get(removeP) - 1);
        }
        
        idx++;
        
        let addP = discount[idx + 9];
        dMap.set(addP, dMap.has(addP) ? dMap.get(addP) + 1 : 1);
    }
    
    return count;
}

function check(wMap, dMap) {
    for (let w of wMap.keys()) {
        if (!dMap.has(w)) return false;
        
        let d = dMap.get(w);
        
        if (d < wMap.get(w)) return false;
    }
    
    return true;
}