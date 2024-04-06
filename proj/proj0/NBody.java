public class NBody{
	public static double readRadius(String filename_){
		In in = new In(filename_);
		int num=in.readInt();
		double radius=in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String filename_){
		In in = new In(filename_);
		int N=in.readInt();
		Planet[] ManyP = new Planet[N];
		double r=in.readDouble();
		for(int i=0;i<N;i++){
			double xp=in.readDouble();
			double yp=in.readDouble();
			double vx=in.readDouble();
			double vy=in.readDouble();
			double m=in.readDouble();
			String img=in.readString();
			ManyP[i]=new Planet(xp,yp,vx,vy,m,img);
		}
		return ManyP;
	}
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = NBody.readPlanets(filename);
		int num=planets.length;

		double r=readRadius(filename);
		StdDraw.setScale(-r,r);
		StdDraw.picture(0,0,"images/starfield.jpg");
		for(int i=0;i<num;i++){
			planets[i].draw();
		}

		StdDraw.enableDoubleBuffering();

		for(double t=0;t<=T;t+=dt){
			double[] xForces=new double[num];
			double[] yForces=new double[num];

			for(int i=0;i<num;i++){
				//xForces[i]=0;
				//yForces[i]=0;
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
			}
			for(int i=0;i<num;i++){
				planets[i].update(dt,xForces[i],yForces[i]);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0;i<num;i++){
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}


		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}