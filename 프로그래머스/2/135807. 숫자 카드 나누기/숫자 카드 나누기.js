// n개의 숫자들의 gcd 구하는 방법
function solution(arrayA, arrayB) {
    let gcdA = arrayA[0];
    let gcdB = arrayB[0];
    for (let i = 1; i < arrayA.length; i++) {
        gcdA = getGCD(gcdA, arrayA[i]);
    }
    for (let i = 1; i < arrayB.length; i++) {
        gcdB = getGCD(gcdB, arrayB[i]);
    }
    
    let answer = 0;
    if (isOK(gcdA, arrayB)) answer = gcdA;
    if (isOK(gcdB, arrayA)) answer = Math.max(answer, gcdB);
    
    return answer;
}

function getGCD(n1, n2) {
    if (n2 == 0) {
        return n1;
    }
    
    return getGCD(n2, n1 % n2);
}

function isOK(div, array) {
    for (let n of array) {
        if (n % div == 0) return false;
    }
    
    return true;
}
