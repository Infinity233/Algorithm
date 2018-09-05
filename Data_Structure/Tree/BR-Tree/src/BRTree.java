import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BRTree {

    private Node nil, root;

    {
        this.nil = new Node();
        this.nil.color = 1;
        this.root = this.nil;
    }

    public void insert(int val) {
        Node x, y, z;
        z = new Node();
        z.key = val;
        y = this.nil;
        x = this.root;

        while (x != this.nil) {
            y = x;
            if (z.key < x.key) {
                x = x.l;
            } else {
                x = x.r;
            }
        }

        z.p = y;
        if (y == this.nil) {
            this.root = z;
        } else if (z.key < y.key) {
            y.l = z;
        } else {
            y.r = z;
        }

        z.l = z.r = this.nil;
        z.color = 0;
        insertFixup(z);
    }

    public void delete(Node z) {
        Node x, y;
        y = z;
        int yOriginalColor = y.color;

        if (z.l == this.nil) {
            x = z.r;
            transplant(z, z.r);
        } else if (z.r == this.nil) {
            x = z.l;
            transplant(z, z.l);
        } else {
            y = z.r;
            while (y.l != this.nil) {
                y = y.l;
            }

            yOriginalColor = y.color;
            x = y.r;
            if (y.p == z) {
                x.p = y;
            } else {
                transplant(y, y.r);
                y.r = z.r;
                y.r.p = y;
            }
            transplant(z, y);
            y.l = z.l;
            y.l.p = y;
            y.color = z.color;
            if (yOriginalColor == 1) {
                deleteFixup(x);
            }
        }
    }

    private void deleteFixup(Node x) {
        while (x != this.root && x.color == 1) {
            if (x == x.p.l) {
                Node w = x.p.r;
                if (w.color == 0) {
                    w.color = 1;
                    x.p.color = 0;
                    leftRotate(x.p);
                    w = x.p.r;
                }
                if (w.l.color == 1 && w.r.color == 1) {
                    w.color = 0;
                    x = x.p;
                } else {
                    if (w.r.color == 1) {
                        w.l.color = 1;
                        w.color = 0;
                        rightRotate(w);
                        w = x.p.r;
                    }

                    w.color = x.p.color;
                    x.p.color = 1;
                    w.r.color = 1;
                    leftRotate(x.p);
                    x = this.root;
                }
            } else {
                Node w = x.p.r;
                if (w.color == 0) {
                    w.color = 1;
                    x.p.color = 0;
                    leftRotate(x.p);
                    w = x.p.r;
                }
                if (w.r.color == 1 && w.r.color == 1) {
                    w.color = 0;
                    x = x.p;
                } else {
                    if (w.r.color == 1) {
                        w.r.color = 1;
                        w.color = 0;
                        rightRotate(w);
                        w = x.p.r;
                    }

                    w.color = x.p.color;
                    x.p.color = 1;
                    w.r.color = 1;
                    leftRotate(x.p);
                    x = this.root;
                }
            }
        }
        x.color = 1;
    }

    public boolean isValid() {
        if (this.root == this.nil) {
            return true;
        }
        if (this.root.color == 0) {
            return false;
        }
        int count = 1;

        Node leftRider = this.root.l;
        while (leftRider != this.nil) {
            if (leftRider.color == 1) {
                ++count;
            }
            leftRider = leftRider.l;
        }

        int num = 0;
        return leftCounter(this.root, count, num);
    }

    private boolean leftCounter(Node root, int count, int num) {
        if (root == this.nil) {
            return true;
        }

        if (root.color == 0 && root.p.color == 0) {
            System.out.println("有连续红节点");
            return false;
        }

        if (root.color == 1) {
            ++num;
        }

        if (root.l == this.nil && root.r == this.nil) {
            if (num != count) {
                System.out.println("路径上黑色节点个数不一样");
                return false;
            }
        }
        return leftCounter(root.l, count, num) && leftCounter(root.r, count, num);
    }

    private void leftRotate(Node x) {
        Node y = x.r;

        x.r = y.l;
        if (y.l != null) {
            y.l.p = x;
        }

        y.p = x.p;
        if (x.p == this.nil) {
            this.root = y;
        } else if (x.p.l == x) {
            x.p.l = y;
        } else if (x.p.r == x) {
            x.p.r = y;
        }

        y.l = x;
        x.p = y;
    }

    private void rightRotate(Node x) {
        Node y = x.l;

        x.l = y.r;
        if (y.r != null) {
            y.r.p = x;
        }

        y.p = x.p;
        if (x.p == this.nil) {
            this.root = y;
        } else if (x.p.l == x) {
            x.p.l = y;
        } else if (x.p.r == x) {
            x.p.r = y;
        }

        y.r = x;
        x.p = y;
    }

    private void insertFixup(Node z) {
        Node y;
        while (z.p.color == 0) {
            if (z.p == z.p.p.l) {
                y = z.p.p.r;
                if (y.color == 0) {
                    z.p.color = 1;
                    y.color = 1;
                    z.p.p.color = 0;
                    z = z.p.p;
                } else {
                    if (z == z.p.r) {
                        z = z.p;
                        this.leftRotate(z);
                    }
                    z.p.color = 1;
                    z.p.p.color = 0;
                    this.rightRotate(z);
                }
            } else {
                y = z.p.p.l;
                if (y.color == 0) {
                    z.p.color = 1;
                    y.color = 1;
                    z.p.p.color = 0;
                    z = z.p.p;
                } else {
                    if (z == z.p.l) {
                        z = z.p;
                        this.rightRotate(z);
                    }
                    z.p.color = 1;
                    z.p.p.color = 0;
                    this.leftRotate(z.p.p);
                }
            }
        }
        this.root.color = 1;
    }

    // 使用v节点替换u节点
    private void transplant(Node u, Node v) {
        if (u.p == this.nil) {
            this.root = v;
        } else if (u == u.p.l) {
            u.p.l = v;
        } else {
            u.p.r = v;
        }
        v.p = u.p;
    }

    private class Node {
        int key;
        Node l, r, p;
        int color;      // 0 Red  1 Black
    }

    public static void main(String[] args) {
        BRTree tree = new BRTree();
        int[] vals = {3, 7, 9, 11, 14, 15, 16, 18, 26};
        for (int val : vals) {
            tree.insert(val);
        }
        System.out.println(tree.isValid());
        System.out.println("end");
    }
}
