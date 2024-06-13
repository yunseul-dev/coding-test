def solution(n, lost, reserve):
    _reserve = sorted([r for r in reserve if r not in lost]) 
    _lost = sorted([l for l in lost if l not in reserve]) 
    
    for r in _reserve:
        if r - 1 in _lost:  
            _lost.remove(r - 1)
        elif r + 1 in _lost:
            _lost.remove(r + 1)
    
    return n - len(_lost)   