package learning.rlearning;

public interface EpisodeCollection {
    public void fromLast();
    public boolean hasPrev();
    public Episode getPrevEpisode();
    public void clear();
}
