public class Planet{
    public double xxPos,yyPos,xxVel,yyVel,mass;
    public String imgFileName;
    static final double G=6.67e-11;

    public Planet(double xP,double yP,double xV,
    double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }
    public double calcDistance(Planet Another){
        double dx=this.xxPos-Another.xxPos;
        double dy=this.yyPos-Another.yyPos;
        return Math.pow(dx*dx+dy*dy,0.5);
        //return Math.pow(Math.pow(this.xxPos-Another.xxPos,2)+Math.pow(this.yyPos-Another.yyPos,2),0.5);
    }
    public double calcForceExertedBy(Planet p){
        double d=this.calcDistance(p);
        return G*this.mass*p.mass/d/d;
    }
    public double calcForceExertedByX(Planet p){
        double dx=p.xxPos-this.xxPos;
        double d=this.calcDistance(p);
        return this.calcForceExertedBy(p)*dx/d;
    }
    public double calcForceExertedByY(Planet p){
        double dy=p.yyPos-this.yyPos;
        double d=this.calcDistance(p);
        return this.calcForceExertedBy(p)*dy/d;
    }
    public void update(double dt,double Fx,double Fy){
        double ax=Fx/mass,ay=Fy/mass;
        xxVel+=ax*dt;
        yyVel+=ay*dt;
        xxPos+=xxVel*dt;
        yyPos+=yyVel*dt;
    }
    public void draw(){
        String FullimgName="images/"+imgFileName;
        StdDraw.picture(xxPos,yyPos,FullimgName);
    }
}