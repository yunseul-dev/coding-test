def solution(citations):
    citations.sort(reverse=True)
    return max(min(index + 1, citation) for index, citation in enumerate(citations))
