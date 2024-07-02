function solution(n, k) {
    let str = n.toString(k);
    let array = str.split('0');
    
    let count = 0;
    
    for (let s of array) {
        if (s.length === 0) continue;
        
        if (isPrime(Number(s))) count++;
    }
    
    return count;
}

function isPrime(n) {
    if (n == 1) return false;
    if (n == 2) return true;
    
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) return false;
    }
    
    return true;
}