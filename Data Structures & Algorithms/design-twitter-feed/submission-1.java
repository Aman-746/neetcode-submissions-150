class Tweet{
    int id;
    int time;

    public Tweet(int id, int time){
        this.id=id;
        this.time=time;
    }
}

class Twitter {

    Map<Integer,Set<Integer>>followers;
    Map<Integer,List<Tweet>>tweets;
    int time;

    public Twitter() {
        followers=new HashMap<>();
        tweets=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(tweets.containsKey(userId)){
            tweets.get(userId).add(new Tweet(tweetId,time++));
            if(tweets.get(userId).size()>10) tweets.get(userId).remove(0);
        } else {
            Tweet tweet=new Tweet(tweetId,time++);
            List<Tweet>li=new ArrayList<>();
            li.add(tweet);
            tweets.put(userId, li);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>res=new ArrayList<>();
        Set<Integer>users=new HashSet<>();
        if(followers.containsKey(userId)){
            users.addAll(followers.get(userId));
        } 
        users.add(userId);
        PriorityQueue<Tweet>pq=new PriorityQueue<>((a,b)->Integer.compare(b.time,a.time));
        for(Integer i:users){
            if(tweets.containsKey(i)){
                List<Tweet>li=tweets.get(i);
                for(Tweet tweet:li) pq.add(tweet);
            }
        }
        int cnt=10;
        while(!pq.isEmpty() && cnt!=0){
            Tweet tw=pq.poll();
            res.add(tw.id);
            cnt--;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            followers.get(followerId).add(followeeId);
        }else{
            Set<Integer>set=new HashSet<>();
            set.add(followeeId);
            followers.put(followerId,set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            followers.get(followerId).remove(followeeId);
        }
    }
}
