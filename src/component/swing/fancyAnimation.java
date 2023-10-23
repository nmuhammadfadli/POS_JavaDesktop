package component.swing;

public class fancyAnimation {

    public fancyAnimation(String start, String end) {
        this.start = new border(start).toArray();
        this.end = new border(end).toArray();
    }

    public fancyAnimation start(String start) {
        this.start = new border(start).toArray();
        return this;
    }

    public fancyAnimation end(String end) {
        this.end = new border(end).toArray();
        return this;
    }

    private float start[];
    private float end[];

    public border getAnimate(float f) {
        float b[] = new float[start.length];
        for (int i = 0; i < start.length; i++) {
            float t = end[i] - start[i];
            t = start[i] + t * f;
            b[i] = t;
        }
        border border = new border();
        border.setBorder(b[0], b[1], b[2], b[3], b[4], b[5], b[6], b[7]);
        return border;
    }
}
