def solution(arr, queries):
    for query in queries:
        s = query[0]
        e = query[1]
        
        for i in range(s, e + 1):
            arr[i] = arr[i] + 1
            
    return arr