package pearls.com.infrastructure.jpa.common;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public abstract class AdapterOperations<D, I, R extends CrudRepository<D, I> & QueryByExampleExecutor<D>> {

    protected R repository;

    @SuppressWarnings("unchecked")
    public AdapterOperations(R repository){
        this.repository = repository;
    }

    public D save(D data){
        return this.repository.save(data);
    }

    public List<D> saveAll(Iterable<D> dataList){
        return ((List<D>) this.repository.saveAll(dataList));
    }

    public void delete(I id){
        this.repository.deleteById(id);
    }

    public D getById(I id){
        return (this.repository.findById(id).orElse(null));
    }

    public List<D> getAll(){
        return (List<D>) this.repository.findAll();
    }

    public List<D> findByExample(D data){
        return ((List<D>) repository.findAll(Example.of(data)));
    }
}
