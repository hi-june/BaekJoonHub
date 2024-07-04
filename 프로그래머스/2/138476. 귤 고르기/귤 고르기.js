function solution(k, tangerine) {
    let map = new Map();
    for (let t of tangerine) {
        map.set(t, map.has(t) ? map.get(t) + 1 : 1);
    }
    
    let keys = [];
    for (let k of map.keys()) {
        keys.push(k);
    }
    keys.sort((k1, k2) => map.get(k2) - map.get(k1));
    
    let idx = 0;
    let count = 0;
    while (k > 0) {
        let val = map.get(keys[idx]);
        
        k = k - val;
        count++;
        idx++;
    }
    
    return count;
}