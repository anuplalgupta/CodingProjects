package practice;

import java.util.*;
/*
Q. Given a package P and its dependencies lets say P1, P2, P3. Again those dependencies can have their own dependecies. find out the order in which 
these dependencies should be build so that the final package P gets built successfully.

P -> P1, P2 and P3
P1 -> P11, P12, and P13
P11 -> P111 and P112
P111 -> P1
*/
public class BuildPackages {
	public List<String> getDependencies(String packageName){
		// Assume that this method is provided which can provide dependencies of any package
		List<String> dependencyList = new ArrayList<String>();
		return dependencyList;
	}
	class InvalidInput

	Map<String, Integer> packageMap = new HashMap<String, Integer>();
	List<String> buildOrder = new LinkedList<String>();

	public void buildPackages(String mainPackage) throws InvalidInputException, CyclicDependencyException{
	    
	    if(mainPackage == null){
	        throw new InvalidInputException();
	    }
	    
	    if(packageMap.get(mainPackage) == 1 ){
	        //package already been seen so cyclic
	        throw new CyclicDependencyException();
	    }
	    
	    if(packageMap.get(mainPackage) == 2){
	        return;
	    }
	    
	    packageMap.put(mainPackage,1);
	    
	    List<String> adjacentPackages = getDependacies(mainPackage);
	    
	    //DFS recursion for each dependency
	    for(String pack : adjacenPackages){
	        buildPackages(pack);
	    }
	    packageMap.put(mainPackage,2);
	    buildOrder.add(mainPackage);
	    return; 
	}

}
