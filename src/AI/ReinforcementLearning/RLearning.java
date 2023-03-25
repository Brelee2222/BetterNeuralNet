package AI.ReinforcementLearning;

import AI.MachineLearning;
import AI.NetworkInputs;

public class RLearning {
    Critic critic;
    Agent agent;

    double discountFactor;

    public double getDiscountFactor() {
        return discountFactor;
    }

    public void train(Environment environment, EpisodeCollection episodeCollection) {
        Policy policy = agent.policy();

        NetworkInputs state;
        NetworkInputs action;
        do {

            state = environment.get();
            action = agent.get(state);
            policy.modifyAction(action);

        } while(
                episodeCollection.addEpisode(state, action, environment.react(action))
        );

        double discountFactor = getDiscountFactor();
        double maxReward = environment.getMaxReward();
        double discountReward = 0;

        MachineLearning criticML = critic.ML();
        MachineLearning agentML = agent.ML();

        double criticError;
        while(episodeCollection.hasPrev()) {
            discountReward = discountReward * discountFactor + episodeCollection.prevEpisodeReward();
            state = episodeCollection.prevEpisodeState();

            criticError = discountReward - critic.getPredictedReward(state) * maxReward;

            agentML.learn(
                    policy.getErrors(episodeCollection.prevEpisodeAction(), agent.get(state), discountReward),
                    agent.getInputs()
            );

            criticML.learn(
                    critic.getError(criticError),
                    critic.getInputs()
            );
        }
    }
}
