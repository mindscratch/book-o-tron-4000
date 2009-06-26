package bookotron.ui.model.impl.collections {

import mx.collections.ArrayCollection;
import mx.collections.ListCollectionView;

public class AuthorsCollection extends ListCollectionView{
    public function AuthorsCollection() {
        super(new ArrayCollection());
    }
}
}