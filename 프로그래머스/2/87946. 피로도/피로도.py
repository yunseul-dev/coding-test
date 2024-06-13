from itertools import permutations

def solution(k, dungeons):
    answer = -1

    for dungeon_permutation in permutations(dungeons): 
        count = 0
        fatigue = k
        for needFatigue, useFatigue in dungeon_permutation:  
            if fatigue >= needFatigue:
                count += 1
                fatigue -= useFatigue
        answer = max(answer, count)
    
    return answer
