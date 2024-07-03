function solution(cards) {
    let nCards = [0, ...cards];
    
    let visited = [];
    for (let i = 0; i <= cards.length; i++) {
        visited[i] = false;
    }
    
    let counts = [];
    for (let i = 1; i < nCards.length; i++) {
        if (visited[i]) continue;
        
        dfs(i, 0, visited, nCards, counts);
    }
    
    counts.sort((n1, n2) => n2 - n1);
    
    return (counts.length == 1) ? 0 : counts[0] * counts[1];
}

function dfs(idx, count, visited, nCards, counts) {
    if (visited[idx]) {
        counts.push(count);
        return;
    }
    
    visited[idx] = true;
    dfs(nCards[idx], count + 1, visited, nCards, counts);
}