import {MDXRemote} from 'next-mdx-remote/rsc';

export default async function Home() {

  const resp = await Promise.resolve("# Hello World!" +
    "\n**hello**")

  return (
    <div>
      <h1>Home</h1>
      <MDXRemote source={resp}/>
    </div>
  )
}
