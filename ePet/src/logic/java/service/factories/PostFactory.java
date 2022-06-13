package service.factories;

import beans.PostBean;
import entities.Post;
import service.Entity;

import java.util.ArrayList;
import java.util.List;

public class PostFactory implements Entity {
    @Override
    public Post createObject() {
        return new Post();
    }

    public List<PostBean> extractPostBeanList(List<Post> src){
        List<PostBean> dest = new ArrayList<>();

        for(Post i: src) {
            PostBean postBean = new PostBean();
            postBean.setId(i.getIdPost());
            postBean.setTitle(i.getTitle());

            postBean.setDescription(i.getDescription());
            postBean.setCreator(i.getCreator());
            postBean.setRegion(i.getRegion());
            postBean.setCountry(i.getCountry());
            postBean.setCity(i.getCity());
            postBean.setKindOfPet(i.getKindOfPet());
            dest.add(postBean);
        }

        return dest;
    }
}
