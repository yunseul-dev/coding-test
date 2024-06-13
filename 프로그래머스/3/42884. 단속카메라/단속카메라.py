def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[1])
    prev = -30000

    for route in routes:
        if prev < route[0]:
            answer += 1
            prev = route[1]
    return answer