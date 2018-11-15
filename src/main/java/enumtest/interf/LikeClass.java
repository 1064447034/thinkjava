package enumtest.interf;

public enum LikeClass {
	WINKEN {
		@Override
		void behavior() {
			System.out.println("behavior1");
		}
	},
	BLIKEN {
		@Override
		void behavior() {
			System.out.println("behavior2");			
		}
	},
	NOD {
		@Override
		void behavior() {
			System.out.println("behavior3");			
		}
	};
	abstract void behavior();
}
