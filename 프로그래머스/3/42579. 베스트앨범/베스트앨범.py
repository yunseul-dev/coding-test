def solution(genres, plays):
    answer = []
    genre_dict = {}  
    genre_play_count = {}  
    
    for i, (genre, play) in enumerate(zip(genres, plays)):
        if genre not in genre_dict:
            genre_dict[genre] = [(i, play)]
            genre_play_count[genre] = play
        else:
            genre_dict[genre].append((i, play))
            genre_play_count[genre] += play
    
    print("genre_dict",genre_dict)
    print("genre_play_count",genre_play_count)
    
    sorted_genres = sorted(genre_play_count, key=lambda x: genre_play_count[x], reverse=True) 
    
    print("sorted_genres", sorted_genres)
    for genre in sorted_genres:  
        top_songs = sorted(genre_dict[genre], key=lambda x: x[1], reverse=True)[:2]  
        answer.extend(song[0] for song in top_songs)  
    
    return answer
