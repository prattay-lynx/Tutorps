
public class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    public AncestralTree(char name) {
        this.name = name;
        this.ancestor = null;
    }

    public void addAsAncestor(AncestralTree[] descendants) {
        for (AncestralTree descendant : descendants) {
            descendant.ancestor = this;
        }
    }

    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
            AncestralTree descendantTwo) {
        int depthOne = getDescendantDepth(descendantOne, topAncestor);
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor);

        while (depthOne > depthTwo) {
            descendantOne = descendantOne.ancestor;
            depthOne--;
        }

        while (depthTwo > depthOne) {
            descendantTwo = descendantTwo.ancestor;
            depthTwo--;
        }

        while (descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        return descendantOne;
    }

    public static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        AncestralTree place = descendant;
        while (descendant != topAncestor) {
            depth++;
            descendant = descendant.ancestor;
        }
        System.out.println("The depth of " + place.name + " is " + depth);
        return depth;
    }

    public static void main(String[] args) {
        // Creating the ancestral tree
        AncestralTree a = new AncestralTree('A');
        AncestralTree b = new AncestralTree('B');
        AncestralTree c = new AncestralTree('C');
        AncestralTree d = new AncestralTree('D');
        AncestralTree e = new AncestralTree('E');
        AncestralTree f = new AncestralTree('F');
        AncestralTree g = new AncestralTree('G');
        AncestralTree h = new AncestralTree('H');
        AncestralTree i = new AncestralTree('I');

        a.addAsAncestor(new AncestralTree[] { b, c });
        b.addAsAncestor(new AncestralTree[] { d, e });
        d.addAsAncestor(new AncestralTree[] { h, i });
        c.addAsAncestor(new AncestralTree[] { f, g });

        // Testing the getYoungestCommonAncestor method
        AncestralTree result = getYoungestCommonAncestor(a, e, i);
        System.out.println("The Youngest Ancestral Tree: " + result.name); // Output: B.

    }
}
