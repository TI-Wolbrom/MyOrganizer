package konkurs;

import java.util.HashMap;

// WORK IN PROGRESS

public class ResourceManager {

	// --------------------------------------------------------------------------------------------------------------------

	private static HashMap<String, byte[]> resources;

	// --------------------------------------------------------------------------------------------------------------------

	private ResourceManager() {}

	// --------------------------------------------------------------------------------------------------------------------

	public static void create() {
		resources = new HashMap<>();
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static void addResource(String name, byte[] bytes) {
		resources.put(name, bytes);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static byte[] getResource(String name) {
		return resources.get(name);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static void eraseResource(String name) {
		resources.remove(name);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static void clearResources() {
		resources.clear();
	}
}
