def solution(people, limit):
    answer = 0 
    people.sort()  
    light, heavy = 0, len(people) - 1  

    while light <= heavy:
        if people[light] + people[heavy] <= limit:     
            light += 1  
        heavy -= 1 
        answer += 1 
    
    return answer