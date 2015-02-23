public class Complex
{
    private final double re;
    private final double im;

    public Complex(double real, double imag)
    {
        re = real;
        im = imag;
    }

    public String toString()
    {
        double ree=0,imm=0;
        checkForInts cfi = new checkForInts();
        if (im == 0)
        {
            boolean ex = cfi.check(String.valueOf(re));
            if (ex==true)
                return (int)re+"";
            else
            {
                ree = java.lang.Math.round(re*1000)/1000.0d;
                ex = cfi.check(String.valueOf(ree));
                if (ex == true)
                    return (int)ree+"";
                else return ree + "";
            }
        }
        if (re == 0)
        {
            boolean ex = cfi.check(String.valueOf(im));
            if (ex==true)
                return (int)im+"i";
            else
            {
                imm = java.lang.Math.round(im*1000)/1000.d;
                ex =cfi.check(String.valueOf(imm));
                if (ex==true)
                    return (int)imm+"i";
                else return imm+"i";
            }
        }
        if (im <  0)
        {
            boolean ex1 = cfi.check(String.valueOf(re));
            boolean ex2 = cfi.check(String.valueOf(im));
            if (ex1==true&&ex2==true)
                return (int)re+"-"+(int)(-im)+"i";
            if (ex1==true&&ex2==false)
            {
                imm = java.lang.Math.round(im*1000)/1000.d;
                ex2 =cfi.check(String.valueOf(imm));
                if (ex2==true)
                    return (int)re+"-"+(int)(-imm)+"i";
                else return (int)re+"-"+(-imm)+"i";
            }
            if (ex1==false&&ex2==true)
            {
                ree = java.lang.Math.round(re*1000)/1000.d;
                ex1 =cfi.check(String.valueOf(ree));
                if (ex1==true)
                    return (int)ree+"-"+(int)(-im)+"i";
                else return ree+"-"+(int)(-im)+"i";
            }
            if (ex1!=true&&ex2!=true)
            {
                ree = java.lang.Math.round(re*1000)/1000.d;
                imm = java.lang.Math.round(im*1000)/1000.d;
                ex1 = cfi.check(String.valueOf(ree));
                ex2 = cfi.check(String.valueOf(imm));
                if (ex1==true&&ex2==true)
                    return (int)ree+"-"+(int)(-imm)+"i";
                else return ree + "-" + (-imm) + "i";
            }
        }
        else
        {
            boolean ex1 = cfi.check(String.valueOf(re));
            boolean ex2 = cfi.check(String.valueOf(im));
            if (ex1==true&&ex2==true)
                return (int)re+"+"+(int)(im)+"i";
            if (ex1==true&&ex2==false)
            {
                imm = java.lang.Math.round(im*1000)/1000.d;
                ex2 =cfi.check(String.valueOf(imm));
                if (ex2==true)
                    return (int)re+"+"+(int)(imm)+"i";
                else return (int)re+"+"+(imm)+"i";
            }
            if (ex1==false&&ex2==true)
            {
                ree = java.lang.Math.round(re*1000)/1000.d;
                ex1 =cfi.check(String.valueOf(re));
                if (ex1==true)
                    return (int)ree+"+"+(int)(im)+"i";
                else return ree+"+"+(int)(im)+"i";
            }
            if (ex1!=true&&ex2!=true)
            {
                ree = java.lang.Math.round(re*1000)/1000.d;
                imm = java.lang.Math.round(im*1000)/1000.d;
                ex1 = cfi.check(String.valueOf(ree));
                ex2 = cfi.check(String.valueOf(imm));
                if (ex1==true&&ex2==true)
                    return (int)ree+"+"+(int)(imm)+"i";
                else return ree + "+" + imm + "i";
            }
        }
        return "";
    }

    public double abs()   { return Math.hypot(re, im); }
    public double phase() { return Math.atan2(im, re); }

    public Complex plus(Complex b)
    {
        Complex a = this;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b)
    {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    public Complex times(Complex b)
    {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    public Complex times(double alpha)
    {
        return new Complex(alpha * re, alpha * im);
    }

    public Complex conjugate() {  return new Complex(re, -im); }

    public Complex reciprocal()
    {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    public double re() { return re; }
    public double im() { return im; }

    public Complex divides(Complex b)
    {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    public Complex exp()
    {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    public Complex sin()
    {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    public Complex cos()
    {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    public Complex tan()
    {
        return sin().divides(cos());
    }

    public static Complex plus(Complex a, Complex b)
    {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }
}
