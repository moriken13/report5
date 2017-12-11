package jp.ac.uryukyu.ie.e175713;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing{

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void attack(LivingThing opponent){
        int damage = (int)(Math.random() * getAttack());
        int rand = (int)(Math.random()*100);
        if (isDead() == false) {
            if (rand<30) {
                if (damage == 0) {
                    System.out.printf("%sの攻撃！痛恨の一撃！！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
                    opponent.wounded(damage * 2);
                }else{
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage*2);
                    opponent.wounded(damage * 2);
                }
            } else{
                if (damage == 0) {
                    System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
                    opponent.wounded(damage);
                }else{
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
        }
    }

    public void wounded(int damage){
        setHitPoint(damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

}