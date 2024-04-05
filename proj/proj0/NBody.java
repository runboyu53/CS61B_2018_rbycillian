public class NBody{
	public static double readRadius(String filename_){
		In in = new In(filename_);
		int N=in.readInt();
		double radius=in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String filename_){
		In in = new In(filename_);
		Planet[] ManyP = new Planet[5];
		in.readLine();
		in.readLine();
		for(int i=0;i<5;i++){
			ManyP[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),
								in.readDouble(),in.readDouble(),in.readString());
		}
		return ManyP;
	}
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] Manyplanet = NBody.readPlanets(filename);
		int num=Manyplanet.length;

		double r=readRadius(filename);
		StdDraw.setScale(-r,r);
		StdDraw.picture(0,0,"images/starfield.jpg");
		for(int i=0;i<num;i++){
			Manyplanet[i].draw();
		}

		StdDraw.enableDoubleBuffering();

		for(double t=0;t<=T;t+=dt){
			double[] xForces=new double[num];
			double[] yForces=new double[num];

			for(int i=0;i<num;i++){
				//xForces[i]=0;
				//yForces[i]=0;
				for(int j=0;j<num;j++){
					if(j==i) continue;
					else{
						xForces[i]+=Manyplanet[i].calcForceExertedByX(Manyplanet[j]);
						yForces[i]+=Manyplanet[i].calcForceExertedByY(Manyplanet[j]);
					}
				}
			}
			for(int i=0;i<num;i++){
				Manyplanet[i].update(dt,xForces[i],yForces[i]);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0;i<num;i++){
				Manyplanet[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}


		StdOut.printf("%d\n",Manyplanet.length);
		StdOut.printf("%.2e\n",r);
		for(int i=0;i<num;i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %12s\n",
			Manyplanet[i].xxPos,Manyplanet[i].yyPos,Manyplanet[i].xxVel,
			Manyplanet[i].yyVel,Manyplanet[i].mass,Manyplanet[i].imgFileName);
		}
	}
}