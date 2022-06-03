public class Perceptron{
	int threshold;
	int rate;
	int[] weights;
	int bias;
	public Perceptron(int nInputs, int thresholdSet, int learningRate) {
		threshold=thresholdSet;
		rate=learningRate;
		weights=new int[nInputs];
		bias=0;
		System.out.println("Initial weights: "+ weights);
		System.out.println("Initial bias: "+ bias);
		System.out.println("Threshold: "+ threshold);
		System.out.println("Learning rate: "+ rate+ "\n");
	}
	
	public int predict(int[] inputs) {
		int z=0;
		int activation=0;
		for(int i=0;i<inputs.length;i++) {
			z+=inputs[i]*weights[i];
		}
		z+=bias;
		if(z>0) {
			activation=1;
		}
		return activation;
	}
	
	public void train(int[][] inputs, int[] labels) {
		int yhat=0;
		int error=0;
		for(int i=0;i<threshold;i++) {
			System.out.println("Iteration "+i);
			for(int j=0;j<inputs.length;j++) {
				System.out.println("Current input: "+inputs[j]+" | Current weight: "+weights[j]+" | Current bias: "+bias);
				yhat=predict(inputs[j]);
				System.out.println("Activation(yhat): "+yhat);
				error=labels[j]-yhat;
				System.out.println("Error: "+labels[j]+"-"+yhat+"="+error);
				for(int k=0;k<inputs[j].length;k++) {
					weights[j]+=(rate*error*inputs[j][k]);
				}
				bias+=rate*error;
				System.out.println("Updated Weights: "+weights);
				System.out.println("Updated Weights: "+weights);
			}
		}
	}
}