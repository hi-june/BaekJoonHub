def solution(n_str):
    if n_str[0] != "0":
        return n_str
    
    # "0000123"
    idx = -1
    for i in range(len(n_str)):
        if n_str[i] != "0":
            idx = i
            break
            
    return n_str[idx:]
            