package records;

/**
 * Input params in mm
 * @param length mm
 * @param width mm
 * @param height mm
 */
public record Dimensions(double length, double width, double height) implements Cloneable {
    public Dimensions {
        if (length < 0 || width < 0 || height < 0) throw new IllegalArgumentException();


    }
    /**
     * @return kg/m^2
     */
    public double volume() {
        return length() * width() * height() * Math.pow(0.001, 3);
    }

    /**
     * Deep copy doesn't make sense, because field are literals and coping by value
     * @return Records are immutable structure so coping is just resource waisting.
     */
    @Override
    public Dimensions clone() {
        return new Dimensions(length(), width(), height());
    }
    /*
     * Нужно ли глубокое копирование dimensions?  Нет.
     *
     * Обычно разделять один ссылочный объект между оригиналом и клоном
     * опасно: изменив его через одну ссылку, ты неявно меняешь и второй
     * объект (aliasing-баг). Именно ради этого и существует deep copy.
     *
     * Но Dimensions — это record с final-компонентами и без сеттеров,
     * то есть НЕИЗМЕНЯЕМЫЙ объект. Его состояние нельзя поменять в принципе.
     * Поэтому общая ссылка совершенно безопасна: клон ведёт себя так, будто
     * у него своя копия, ведь объект всё равно никогда не изменится.
     * Глубокое копирование тут добавило бы лишнюю аллокацию без всякой пользы.
     *
     * Ключ — именно НЕИЗМЕНЯЕМОСТЬ Dimensions, а не «примитивные поля».
     */

    // Суть рекорда что все базовые абс методы уже релизнуты по полям
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Dimensions(double length1, double width1, double height1)))  return false;
//        if (height1 != this.height
//                || width1 != this.width
//                || length1 == this.length) {
//            return false;
//        }
//        return true;
    }

