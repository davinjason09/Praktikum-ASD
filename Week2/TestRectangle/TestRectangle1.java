public class TestRectangle1 {
    public static void main(String[] args) {
        // (1)
        // Rectangle rect0 = new Rectangle();
        // rect0.width = Math.random();
        // rect0.height = Math.random();

        // Rectangle rect1 = new Rectangle();
        // rect1.width = Math.random();
        // rect1.height = Math.random();

        // System.out.printf("rect0\nwidth: %.16f\nheight: %.16f\narea: %.16f\n", rect0.width, rect0.height, rect0.width*rect0.height);
        // System.out.printf("rect1\nwidth: %.16f\nheight: %.16f\narea: %.16f\n", rect1.width, rect1.height, rect1.width*rect1.height);

        // (2)
        // Rectangle[] rects = new Rectangle[2];
        // rects[0] = rect0;
        // rects[1] = rect1;

        // for (int i = 0; i < rects.length; i++) {
        //     System.out.println("rect" + i + "\nwidth: " + rects[i].width + "\nheight: " + rects[i].height + "\narea: " + rects[i].width*rects[i].height);
        // }
        
        // (3)
        // Rectangle[] rects = new Rectangle[10];
        
        // for (int i = 0; i < rects.length; i++) {
        //         rects[i] = new Rectangle();
        //         rects[i].width = Math.random();
        //         rects[i].height = Math.random();
        //     System.out.println("rect" + i + "\nwidth: " + rects[i].width + "\nheight: " + rects[i].height + "\narea: " + rects[i].width*rects[i].height);
        // }
        
        // (4)
        Rectangle1[] rects = new Rectangle1[10];

        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        int iMax = 0;
        int iMin = 0;

        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle1();
            rects[i].width = Math.random();
            rects[i].height = Math.random();
            double area = rects[i].width*rects[i].height;

            if (max < area) {
                max = area;
                iMax = i;
            }
            if (min > area) {
                min = area;
                iMin = i;
            }
        }
        System.out.printf("Max Rectangle =\nrect%d\nwidth: %.16f\nheight: %.16f\narea: %.16f\n", iMax, rects[iMax].width, rects[iMax].height, rects[iMax].width*rects[iMax].height);
        System.out.printf("Min Rectangle =\nrect%d\nwidth: %.16f\nheight: %.16f\narea: %.16f\n", iMin, rects[iMin].width, rects[iMin].height, rects[iMin].width*rects[iMin].height);
    }
}
