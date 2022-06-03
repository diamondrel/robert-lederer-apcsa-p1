import java.util.Arrays;

public class Perceptron{
	int threshold;
	double rate;
	int[] weights;
	int bias;
	public Perceptron(int nInputs) {
		threshold=100;
		rate=0.01;
		weights=new int[nInputs];
		bias=0;
		System.out.println("Initial weights: "+ weights);
		System.out.println("Initial bias: "+ bias);
		System.out.println("Threshold: "+ threshold);
		System.out.println("Learning rate: "+ rate+ "\n");
	}
	public Perceptron(int nInputs, int thresholdSet, double learningRate) {
		threshold=thresholdSet;
		rate=learningRate;
		weights=new int[nInputs];
		bias=0;
		System.out.println("Initial weights: "+ Arrays.toString(weights));
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
			System.out.println("\nIteration "+i);
			for(int j=0;j<inputs[0].length;j++) {
				System.out.println("\nJteration "+j);
				System.out.println("Current input: "+Arrays.toString(inputs[j])+" | Current weight: "+weights[j]+" | Current bias: "+bias);
				yhat=predict(inputs[j]);
				System.out.println("Activation(yhat): "+yhat);
				error=labels[j]-yhat;
				System.out.println("Error: "+labels[j]+"-"+yhat+"="+error);
				for(int k=0;k<inputs[j].length;k++) {
					weights[j]+=(rate*error*inputs[j][k]);
				}
				bias+=rate*error;
				System.out.println("Updated Weights: "+Arrays.toString(weights));
				System.out.println("Updated Biases: "+bias);
			}
		}
	}
	public static void main(String[] args) {
		int[][] inputMatrix = new int[4][2];
		int[] labels={1,0,0,0};
		
		String gate="AND";
		
		if(gate.equals("OR"))
			labels = new int[]{1,1,1,0};
		else if(gate.equals("NAND"))
			labels = new int[]{0,1,1,1};
		else if(gate.equals("XOR")) 
			labels = new int[]{0,1,1,0};
		
		inputMatrix[0]= new int[] {1,1};
		inputMatrix[1]=new int[] {1,0};
		inputMatrix[2]= new int[] {0,1};
		inputMatrix[3]=new int[] {0,0};
		
		Perceptron perceptron = new Perceptron(2,10,1);
		
		perceptron.train(inputMatrix, labels);
		
		int a=0;
		int b=1;
		System.out.println("\nResults\n");
		System.out.println("Inputs: "+a+", "+b);
		int output=perceptron.predict(new int[] {a,b});
		System.out.println("Output: "+output);
	}
}