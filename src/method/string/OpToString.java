package method.string;

import method.ToString;
import node.Node;
import node.operation.AddNode;
import node.operation.MulNode;
import node.operation.OpNode;
import node.operation.SubNode;

public class OpToString implements ToString {
    @Override
    public String print(Node node) {
        StringBuilder strBild = new StringBuilder();
        Node left;
        Node right;
        // 1: add left surround
        strBild.append("(");
        // 2: get node
        left = ((OpNode) node).getLeft();
        right = ((OpNode) node).getRight();
        // 3:operation
        if (node instanceof AddNode || node instanceof SubNode) {
            if (!left.isZero() && !right.isZero()) {
                strBild.append(left.toString());
                if (node instanceof AddNode) {
                    strBild.append("+");
                } else {
                    strBild.append("-");
                }
                strBild.append(right.toString());
            } else if (left.isZero()) {
                strBild.append(right.toString());
            } else {
                strBild.append(left.toString());
            }
        } else if (node instanceof MulNode) {
            if (left.isZero() || right.isZero()) {
                strBild.append("0");
            } else {
                strBild.append(left.toString());
                strBild.append("*");
                strBild.append(right.toString());
            }
        }
        // 4: add right surround
        strBild.append(")");
        return strBild.toString();
    }
}
