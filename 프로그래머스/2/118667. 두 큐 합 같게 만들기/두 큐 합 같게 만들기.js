function solution(queue1, queue2) {
    let t1 = getTotal(queue1);
    let t2 = getTotal(queue2);
    
    let queue = [...queue1, ...queue2];
    let idx1 = 0;
    let idx2 = queue1.length;
    
    let count = 0;
    while (t1 !== t2) {
        if (count > (queue1.length + queue2.length) * 2) {
            return -1;
        }
        
        if (t1 < t2) {
            t1 += queue[idx2];
            t2 -= queue[idx2];
            idx2++;
        } else if (t1 > t2) {
            t1 -= queue[idx1];
            t2 += queue[idx1];
            idx1++;
        }
        
        count++;
    }
    
    return count;
}

function getTotal(queue) {
    let total = 0;
    for (let q of queue) {
        total += q;
    }
    
    return total;
}