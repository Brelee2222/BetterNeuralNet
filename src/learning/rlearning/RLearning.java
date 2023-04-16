package learning.rlearning;

import util.inputs.NetworkInputs;

public abstract class RLearning {
    double minReward = 0;
    double maxReward = 0;

    public abstract double getCriticPrediction(NetworkInputs inputs);

    public abstract NetworkInputs getAgentAction(NetworkInputs inputs);

    public abstract void learnAgent(NetworkInputs errorSignal);

    public abstract void learnCritic(double error);

    public abstract double getDiscountFactor();

    public abstract Policy getPolicy();

    public double getMinReward() {
        return minReward;
    }
    public double getMaxReward() {
        return maxReward;
    }

    public void learn(EpisodeCollection episodeCollection) {
        double discountFactor = getDiscountFactor();

        double newMinReward = getMinReward();
        double newMaxReward = getMaxReward();

        double rewardScale = newMaxReward - newMinReward;
        double rewardMin = newMinReward;

        double discountedReward = 0;

        episodeCollection.fromLast();

        Policy policy = getPolicy();

        while(episodeCollection.hasPrev()) {
            Episode episode = episodeCollection.getPrevEpisode();
            discountedReward = discountedReward * discountFactor + episode.getReward();

            if(discountedReward > newMaxReward) {
                newMaxReward = discountedReward;
            } else if(discountedReward < newMinReward) {
                newMinReward = discountedReward;
            }

            NetworkInputs state = episode.getState();

            double error = getCriticPrediction(state) * rewardScale - rewardMin - discountedReward;

            learnCritic(error);

            learnAgent(policy.getErrorSignal(episode.getAction(), getAgentAction(state), error));
        }

        minReward = newMinReward;
        maxReward = newMaxReward;
    }
}