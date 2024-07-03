function solution(elements) {
    let nums = new Set();
    
    for (let len = 1; len <= elements.length; len++) {
        // init
        let total = 0;
        for (let i = 0; i < len; i++) {
            total += elements[i];
        }
        nums.add(total);
        
        // calculate
        let idx = 0;
        while (idx < elements.length - 1) {
            total -= elements[idx];
            idx++;
            total += elements[(idx + len - 1) % elements.length];
            
            nums.add(total);
        }
    }
    
    return nums.size;
}